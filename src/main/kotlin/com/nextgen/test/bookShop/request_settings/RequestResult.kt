package com.nextgen.test.bookShop.request_settings

import java.util.*

class RequestResult<out T>(
        val timestamp: Date,
        val data: T?,
        val code: Int,
        val status: String,
        val message: String?
        ) {

    companion object {

        fun <T> error(data: T, code: Int, status: String,message: String): RequestResult<T> {
            return RequestResult(Date(), null, code, status, message)
        }

        fun <T> success(data: T, code: Int = 200): RequestResult<T> {
            return RequestResult(Date(), data, code, "SUCCESS", "")
        }

    }

}