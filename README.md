# kotlin-example-operator

## Code

```kotlin
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
```
Check the full source code of the [operator](https://github.com/jvm-operators/kotlin-example-operator/blob/master/src/main/kotlin/io/radanalytics/operator/kotlin/BarOperator.kt)

## Usage
```
# build the project
mvn clean install

# assuming Kubernetes is up and running, run the operator
java -jar ./target/kotlin-example-operator-*.jar
```

then in another terminal

```
# create resource bar
kubectl create -f examples/bar.yaml

# delete resource bar
kubectl delete cm my-bar
```

You should be able to see
![alt text](https://github.com/jvm-operators/kotlin-example-operator/raw/master/bar-operator.png "Terminal dump")
