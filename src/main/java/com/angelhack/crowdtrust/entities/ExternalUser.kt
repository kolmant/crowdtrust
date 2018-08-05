package com.angelhack.crowdtrust.entities

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class ExternalUser (

    @JsonProperty(value = "email")
    var email: String,

    @JsonProperty(value = "name")
    var name: String,

    @JsonProperty(value = "id")
    var id: Int
)