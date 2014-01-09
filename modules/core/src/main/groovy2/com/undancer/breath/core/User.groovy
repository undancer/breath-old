package com.undancer.breath
/**
 * Created by undancer on 14-1-4.
 */
class User {

    String username

    String password

    int age

    static constraints = {
        username size: 0..255, blank: false
        age size: 0..16, blank: true
    }
}

class V {

    def subject

    void validate(def obj) {
        subject = obj
        obj.metaClass.getMethods().each {
            println(it)
        }
        try {
            Closure closure = obj.constraints
            closure.delegate = this
            closure.call()
        } catch (MissingPropertyException e) {

        }
        println "Validation complete."
    }

    def invokeMethod(String name, def args) {
        def val = subject.getProperty(name)
        args.first().each { key, value ->
            switch (val?.class) {
                case null:
                    if (key == 'blank' && !val) {
                        println "failed: property '${name}' is null."
                    }
                    break
                case Integer:
                    if (key == 'size' && !value.contains(val)) {
                        println "failed: Integer property '${name}' has value '${val}' not in range '${it.value.inspect()}'."
                    }
                    break
                case String:
                    if (key == 'size' && !value?.contains(val.length())) {
                        println "failed: String property '${name}' has value '${val}' not in length range '${value.inspect()}'."
                    }
                    break
                default:
                    println val?.class
                    break
            }
        }
    }

    public static void main(String[] args) {
        def user = [username: 'hello', age: 18] as User
        V v = [] as V
        v.validate(user)
    }
}