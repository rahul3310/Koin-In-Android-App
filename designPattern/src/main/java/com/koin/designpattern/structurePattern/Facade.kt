package com.koin.designpattern.structurePattern

class NetworkClient {
    fun init(baseUrl: String) {/* init client code*/
    }

    fun getUrl(url: String): ByteArray {
        return ByteArray(0)
    }
}

class AuthManager {
    fun authenticate(token: String) {
        /* authentication code */
    }
}

class ImageCache {
    val cacheMap = mutableMapOf<String, ByteArray>()

    fun put(key: String, data: ByteArray){ cacheMap[key] = data }
    fun get(key: String) : ByteArray? = cacheMap[key]
}

class ImagerLoader(
    private val client: NetworkClient,
    private val authManager: AuthManager,
    private val cache: ImageCache
){
    fun init(baseUrl: String,token: String){
        client.init(baseUrl)
        authManager.authenticate(token)
    }

    fun loadImage(url: String): ByteArray {
        val cached = cache.get(url)
        if (cached != null) return cached

        val data = client.getUrl(url)
        cache.put(url, data)
        return data
    }
}