package userdata

import grails.converters.JSON

import org.codehaus.groovy.grails.web.json.JSONObject
import static org.springframework.http.HttpStatus.*

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;





class PersonController {
	def personService
	LoginController logincontroller=new LoginController()
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Person.list(params), model:[personInstanceCount: Person.count()]
	}

	def show(Person personInstance) {
		respond personInstance
	}

	def create() {
		respond new Person(params)
	}
	//def index() {
		//def persons = Person.list()
		//[persons:persons]
	//}
	def form(){}
	def save(){
		//log.info("************ save");
		def person = new Person()
		person.id=(params.int("id"))
		person.firstName=(params.firstName)
		person.lastName=(params.lastName)
		person.age=(params.int("age"))
		person.email=(params.email)
		
		person=person.save(flush:true)
		render view:"/person/display.gsp", model:[person:person]
		//render person.id
		//render person.firstName
		//render person.lastName
		//render person.age
		
		//def status=new JSONObject();
		//status.put("person",person)
		//render status as JSON
		//render view: "form.gsp", model: [person:person]
	}
	def updatePerson(){}
	def update(){
		//log.info("update");
		//log.info(params.id)
		def person = Person.findById(params.id)
		person.id=(params.int("id"))
		person.firstName=(params.firstName)
		person.lastName=(params.lastName)
		person.age=(params.int("age"))
		person.email=(params.email)
		person=person.save(flush:true)
		render view:"/person/display.gsp", model:[person:person]
		//def status=new JSONObject();
		//status.put("person",person)
		//render status as JSON
		//render "updated"
	}
	def deletePerson(){}
	def delete(){
		def person = Person.get(params.id)
		person.id=(params.int("id"))
		//person.firstName=(params.firstName)
		//person.lastName=(params.lastName)
		//person.age=(params.int("age"))
		//person.email=(params.email)
        person.delete(flush:true)		
		render view:"/person/display.gsp", model:[person:person]
		}
	
	def display(){
		
	}

	
	def myservice() {
	log.info("Person Controller myservice action")
	def responseData = new HashMap<>()
	def result,url
	def mode=params.mode
	def myaction = params.myaction
	def id=params.id
	def firstName=params.firstName
	def lastName=params.lastName
	def age=params.age
	def email=params.email
	
	
	if( ! (isValid(myaction) && isValid(mode))){
        responseData.put(getMessages('default.status.label'),getMessages('default.error.message'))
		responseData.put(getMessages('default.message.label'),getMessages('default.params.missing'))
		logincontroller.renderPage(mode, url, responseData)
		return
	}
	if(myaction.equals("save")) {
		if( ! (isValid(id)&& isValid(firstName)&& isValid(lastName) && isValid(age)&& isValid(email))){
			responseData.put(getMessages('default.status.label'),getMessages('default.error.message'))
			responseData.put(getMessages('default.message.label'),getMessages('default.params.missing'))
			logincontroller.renderPage(mode, url, responseData)
			return
		}
		else {
			log.info("***********person controller*****")
			log.info(id)
			log.info(firstName)
			log.info(lastName)
			log.info(age)
			log.info(email)
			log.info("************************")
			result=personService.save(id,firstName,lastName,age,email,)
			log.info("****&&&&&&")
			log.info(result)
		}
	}
	if(myaction.equals("update")) {
		if( ! (isValid(id)&& isValid(firstName) && isValid(lastName)&& isValid(age)&& isValid(email))){
			responseData.put(getMessages('default.status.label'),getMessages('default.error.message'))
			responseData.put(getMessages('default.message.label'),getMessages('default.params.missing'))
			logincontroller.renderPage(mode, url, responseData)
			return
		}
		else {
			result=personService.update(id,firstName,lastName,age,email)
		}
	}
	if(myaction.equals("delete")) {
		result=personService.delete(id)
	}
	logincontroller.renderPage(mode, url, result)

	}
	
	def isValid(param){
		if(null == param || param.trim() == "")
			return false
		return true
		}
		def getMessages(code) {
			return message(code : code)
		}
	
}

	
	
	
	
	
