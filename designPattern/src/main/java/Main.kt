import com.koin.designpattern.structurePattern.AuthManager
import com.koin.designpattern.structurePattern.ImageCache
import com.koin.designpattern.structurePattern.ImagerLoader
import com.koin.designpattern.structurePattern.NetworkClient
import creationPattern.builder.User
import creationPattern.factory.PaymentFactory
import creationPattern.singleton.AppLogger
import creationPattern.singleton.ConfigManager
import creationPattern.prototype.Vehicle

/**
 * `Creation Patterns`
 *
 * Singleton
 *
 * Factory
 *
 * Builder
 *
 * Prototype
 *
 * `Structural Patterns`
 *
 * Adapter
 *
 * Facade
 *
 * Decorator
 *
 * `Behavioral Patterns`
 *
 * Observer
 *
 * Strategy
 *
 * Command
 *
 * Memento
 *
 * `Android Architecture Patterns`
 *
 * Repository
 *
 * UseCase
 *
 * Dependency Injection
 * */

fun main() {

    //How to create object of singleton pattern
    AppLogger.info("This is a singleton object creation")

    ConfigManager.init(
        mapOf(
            "baseUrl" to "https://api.example.com",
            "env" to "production"
        )
    )

    // STEP 2: Get the singleton instance
    val configManager = ConfigManager.get()

    //Builder Object creation
    val user = User.Builder().setName("Rahul")
        .setAge(25)
        .build()

    //Factory object creation
    val paymentFactory = PaymentFactory.create("google_pay")
    PaymentFactory.getInstance().pay()

    //ProtoType Object creation
    val v1 = Vehicle("Honda", "City", 1000000)
    val v2 = v1.clone()

    println(v2)  // Same data but different object


    val imageLoader = ImagerLoader(NetworkClient(), AuthManager(), ImageCache())
    imageLoader.init("base-url", "token-xyz")
    imageLoader.loadImage("image-url")

}