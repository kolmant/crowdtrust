package com.angelhack.crowdtrust.entities.projects

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class Voucher (


    //var outGoings: List<OutGoings>,

    @JsonProperty(value = "id")
    var id: Int,

    @JsonProperty(value = "filename")
    var fileName: String
)
