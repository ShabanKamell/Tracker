package tracker.common.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import tracker.common.data.pref.SharedPref
import java.io.IOException

class TokenInterceptor(private val pref: SharedPref) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
                .addHeader("Authorization", "Bearer ${pref.token}")
                .build()

        println("accessToken = ${pref.token}")

        return chain.proceed(request)
    }
}
