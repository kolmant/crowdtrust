package com.angelhack.crowdtrust.entities.projects

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class OutGoings {

    @JsonProperty(value = "subtype")
    var subtype: String = ""

    @JsonProperty(value = "type")
    var type: String = ""

    @JsonProperty(value = "quantity")
    var quantity: Int = 0

    @JsonProperty(value = "total_price")
    var totalPrice: Int = 0

    @JsonProperty(value = "voucher_id")
    var voucherId: Int = 0

    @JsonProperty(value = "project_id")
    var projectId: Int = 0
}
