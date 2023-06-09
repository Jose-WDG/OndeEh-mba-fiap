package dependencies

object Versions {
    const val okHttpVersion = "4.2.1"
    const val gsonVersion = "2.8.5"
    const val retrofitVersion = "2.9.0"
    const val moshiConverterVersion = "2.3.0"
}

object Deps {
    object Retrofit {
        const val retrofit =
            "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val retrofitMoshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}"
        const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
        const val okhttp3 =
            "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    }
}
