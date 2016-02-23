package userdata
import grails.converters.JSON;
class LoginController {

     def index() { 
	log.info("welcome")
	}
	/*Action to renderPage
	 * @params mode,url,map
	 */
	def renderPage(mode,url,map){
		log.info("LoginController renderPage Action")
		 if(mode == "mobile"){
			render map as JSON
		}
		 else{
			 render map as JSON
		 }
	}
}
