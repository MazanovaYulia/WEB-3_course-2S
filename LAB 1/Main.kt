import kotlin.random.Random

fun main() {
    MobilePhone("8 (800) 555 35-35").apply {
        val first = Contact("Mary Clark", "8 (800) 678 00-35")
        val second = Contact("John Lennon", "8 (800) 985 35-00")
        println("\nЗадание 1\n1: ")
        printContacts()

        println("\n2: ")
        addNewContact(second)
        printContacts()

        println("\n3: ")
        updateContact(second, first)
        printContacts()

        println("\n4: ")
        removeContact(first)
        printContacts()

        println("\n5: ")
        addNewContact(first)
        findContact(first).let(::println)
        printContacts()

        println("\n6: ")
        queryContact(first.name)?.let(::println)

        println("\n Задание 2:")
        val newTree = Node(2).apply {
            insert(5)
            insert(1)
            insert(3)
            println(this)
            delete(3)
        }
    }
}

class MobilePhone(myNumber: String) {
    private val myContacts = mutableListOf(Contact("Mezhetskaya Yulia", myNumber))

    fun addNewContact(newContact: Contact) = myContacts.add(newContact)

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val isUpdated = myContacts.removeIf {
            it == oldContact
        }
        if (isUpdated) myContacts.add(newContact)
        return isUpdated
    }

    fun updateContact(newContact: Contact) {
        myContacts.replaceAll {
            if (it.id == newContact.id) newContact else it
        }
    }

    fun removeContact(contact: Contact) = myContacts.remove(contact)

    fun findContact(contact: Contact): Int = myContacts.indexOf(contact)

    fun queryContact(query: String): Contact? = myContacts.firstOrNull { it.name == query }

    fun printContacts() = myContacts.forEach(::println)
}

data class Contact(val name: String, val phoneNumber: String, val id: Int = Random.nextInt(1, 100))
