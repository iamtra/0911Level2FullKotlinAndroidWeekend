package concurrency


fun getCpuInfo(): Pair<Int, Int> {
    val physical = Runtime.getRuntime()
        .exec("sysctl -n hw.physicalcpu")
        .inputStream.bufferedReader().readText().trim().toInt()

    val logical = Runtime.getRuntime()
        .exec("sysctl -n hw.logicalcpu")
        .inputStream.bufferedReader().readText().trim().toInt()

    return physical to logical
}

fun main() {
    val (physical, logical) = getCpuInfo()

    println("Physical cores: $physical")
    println("Logical cores (threads): $logical")

    val threadsPerCore = logical / physical
    println("Threads per core: $threadsPerCore")
}