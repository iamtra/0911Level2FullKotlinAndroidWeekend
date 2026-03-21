package oops

abstract class Profile {
    fun downloadProfile() {
        println("Downloading profile....")
    }

    abstract fun getFileId()
}

class CustomerProfile : Profile() {
    override fun getFileId() {

    }

}

class UserProle : Profile() {
    override fun getFileId() {

    }
}

fun main() {
    val profile = UserProle()
    profile.downloadProfile()
}

/**
 * Deposit
 */