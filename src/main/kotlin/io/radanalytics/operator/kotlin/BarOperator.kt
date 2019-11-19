package io.radanalytics.operator.kotlin

import io.radanalytics.operator.common.AbstractOperator
import io.radanalytics.operator.common.EntityInfo
import io.radanalytics.operator.common.Operator
import javax.inject.Singleton

@Singleton
@Operator(forKind = BarInfo::class, prefix = "radanalytics.io")
class BarOperator : AbstractOperator<BarInfo>() {

    override fun onDelete(bar: BarInfo) {
        log.info("deleted 'bar' with name ${bar.name} and parameter = ${bar.parameter}")
    }

    override fun onAdd(bar: BarInfo) {
        log.info("created 'bar' with name ${bar.name} and parameter = ${bar.parameter}")
    }
}

class BarInfo(var nameValue: String, var parameter: String) : EntityInfo() {

    override fun setName(value: String) {
        nameValue = value
    }

    override fun getName(): String {
        return nameValue
    }
}
