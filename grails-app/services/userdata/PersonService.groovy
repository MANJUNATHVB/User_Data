package userdata

import java.text.SimpleDateFormat;

import grails.transaction.Transactional

@Transactional
class PersonService {

   def grailsApplication
	
		def getInstance() {
			log.info("PersonService getInstance ")
			try{
				return new Person()
			}
			catch(Exception e) {
				log.info("PersonService getInstance Exception::"+e)
			}
		}
		
		def save(Person personInstance) {
			log.info("PersonService save-Object ")
			try{
				if(personInstance == null) {
					return false
				}
				else{
					personInstance.save flush:true
					return true
				}
			}
			catch(Exception e) {
				log.info("personService save-Object Exception::"+e)
			}
		}
		def save(id,firstName,lastName,age,email){
			log.info("PersonService save-params ")
			def resultData=new HashMap<>()
			String []args=["Person"]
			try{
				def check=Person.findById(id,firstName,lastName,age,email)
				if(!check){
					def personInstance=getInstance()
					if(personInstance){
						personInstance.id=id.toLong()
						personInstance.firstName=firstName
						personInstance.lastName=lastName
						personInstance.age=age.toLong()
						personInstance.email=email
			
						def sts= save(personInstance)
						if(sts){
							resultData.put(getMessage("default.status.label"),getMessage("default.success.message"))
							resultData.put(getMessage("default.message.label"),getMessage("default.insertion.successmessage",args))
						}
						else{
							resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
							resultData.put(getMessage("default.message.label"),getMessage("default.insertion.errormessage",args))
						}
					}
					else {
						resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
						resultData.put(getMessage("default.message.label"),getMessage("default.object.notfound",args))
					}
				}
				else{
					resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
					resultData.put(getMessage("default.message.label"),getMessage("default.object.alreadyexist",args))
				}
				return resultData
			}
			catch(Exception e) {
				log.info("PersonService save Exception::"+e)
			}
		}
		def update(id,firstName,lastName,age,email){
			log.info("personService update")
			def resultData=new HashMap<>()
			String []args=["Person"]
			try{
				def personInstance=Person.findById(id)
				if(personInstance) {
					personInstance.id=id.toLong()
					personInstance.firstName=firstName
					personInstance.lastName=lastName
					personInstance.age=age.toLong()
					personInstance.email=email
					
					def status=save(personInstance)
					if(status){
						resultData.put(getMessage("default.status.label"),getMessage("default.success.message"))
						resultData.put(getMessage("default.message.label"),getMessage("default.update.successmessage",args))
					}
					else{
						resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
						resultData.put(getMessage("default.message.label"),getMessage("default.update.errormessage",args))
					}
				}
				else {
					resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
					resultData.put(getMessage("default.message.label"),getMessage("default.object.notfound",args))
				}
				return resultData
			}
			catch(Exception e) {
				log.info("personService update Exception")
			}
		}
		def delete(id) {
			log.info("personService delete")
			def resultData=new HashMap<>()
			String []args=["Person"]
			try{
				def personInstance=Person.findById(id)
				if(personInstance) {
					personInstance.delete flush:true
					resultData.put(getMessage("default.status.label"),getMessage("default.success.message"))
					resultData.put(getMessage("default.message.label"),getMessage("default.delete.successmessage",args))
				}
				else{
					resultData.put(getMessage("default.status.label"),getMessage("default.error.message"))
					resultData.put(getMessage("default.message.label"),getMessage("default.delete.errormessage",args))
				}
				return resultData
			}
			catch(Exception e) {
				log.info("personService delete Exception::"+e)
			}
		}
		def getMessage(String code) {
			return getMessage(code,null)
		}
	
		def getMessage(String code,String[] args) {
			def appCtx = grailsApplication.getMainContext()
			return appCtx.getMessage(code,args,Locale.default)
		}
}
