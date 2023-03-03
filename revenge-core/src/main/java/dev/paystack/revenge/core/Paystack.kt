package dev.paystack.revenge.core

import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope

class Paystack @RestrictTo(Scope.LIBRARY_GROUP) constructor() {

    class Builder {
        fun build() = Paystack()
    }
}