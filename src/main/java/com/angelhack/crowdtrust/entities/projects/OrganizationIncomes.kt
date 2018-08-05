package com.angelhack.crowdtrust.entities.projects

import com.angelhack.crowdtrust.entities.projects.Incomes
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by David Useche on 4/08/2018.
 */
class OrganizationIncomes {

    @JsonProperty("id")
    var id: Int = 0

    @JsonProperty("quantity")
    var quantity: Int = 0

    @JsonProperty("organization_id")
    var donatorId: Int = 0

    @JsonProperty("project_id")
    var projectId:Int = 0
}
