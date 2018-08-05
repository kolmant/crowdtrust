package com.angelhack.crowdtrust.entities.projects

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class OutGoings (

    @JsonProperty(value = "sub_type_id")
    var type: String,

    @JsonProperty(value = "quantity")
    var quntity: Int,

    @JsonProperty(value = "total_price")
    var totalPrice: Int,

    @JsonProperty(value = "voucher_id")
    var voucherId: Int,

    @JsonProperty(value = "project_id")
    var projectId: Int
)
