package com.angelhack.crowdtrust.entities.projects

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class OutGoingType (

    @JsonProperty(value = "id")
    var id: Int,

    @JsonProperty(value = "name")
    var name: String
)
