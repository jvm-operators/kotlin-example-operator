package io.radanalytics.operator.kotlin

import io.radanalytics.operator.common.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Operator(forKind = "bar", prefix = "radanalytics.io", infoClass = BarInfo::class)
class BarOperator : AbstractOperator<BarInfo>() {

    val log: Logger = LoggerFactory.getLogger(BarOperator::class.qualifiedName)

    override fun onDelete(bar: BarInfo) {
        log.info("deleted 'bar' with name ${bar.name} and parameter = ${bar.parameter}")
    }

    override fun onAdd(bar: BarInfo) {
        log.info("created 'bar' with name ${bar.name} and parameter = ${bar.parameter}")
    }
}

class BarInfo(var nameValue: String, var parameter: String) : EntityInfo {

    constructor() : this("", "")

    override fun setName(value: String) {
        nameValue = value
    }

    override fun getName(): String {
        return nameValue
    }
}
