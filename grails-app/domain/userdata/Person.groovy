package userdata

class Person {
	int id
	String firstName
	String lastName
	int age
	String email

    static constraints = {
		id(unique:true,blank:false)
		firstName(blank: false, nullable: false)
		lastName(blank: false, nullable: false)
		age(min:18)
		email(blank: false, email: true)
    }
}
