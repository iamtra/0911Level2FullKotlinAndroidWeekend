package controlFlow


data class ProductModel(
    val id: String,
    val name: String,
    val brand: String,
    val expireDate: String,
    val fullPrice: String,
    val tax: Float,
    val discount: Float
)

fun main() {
    val productList = listOf(
        ProductModel("001", "Laptop", "Dell", "2026-12-31", "1200", 0.1f, 0.05f),
        ProductModel("002", "Smartphone", "Samsung", "2025-11-30", "800", 0.08f, 0.1f),
        ProductModel("003", "Headphones", "Sony", "2027-01-15", "150", 0.05f, 0.02f),
        ProductModel("004", "Smartwatch", "Apple", "2026-06-20", "400", 0.07f, 0.03f),
        ProductModel("005", "Tablet", "Lenovo", "2025-09-10", "600", 0.09f, 0.08f),
        ProductModel("006", "Monitor", "LG", "2027-03-05", "300", 0.06f, 0.04f),
        ProductModel("007", "Keyboard", "Logitech", "2026-08-25", "80", 0.05f, 0.01f),
        ProductModel("008", "Mouse", "Razer", "2025-12-12", "50", 0.05f, 0.02f),
        ProductModel("009", "Printer", "HP", "2026-11-11", "250", 0.08f, 0.05f),
        ProductModel("010", "Camera", "Canon", "2027-07-07", "900", 0.1f, 0.07f)
    )

//    println("Search...: ")
//    val searchValue = readln()
//    checkProductInStock(searchValue, productList) {
//        if (it) {
//            println("Product is in stock")
//        } else {
//            println("Product out of stock")
//        }
//    }

    print("Enter bank code: ")
    val bankCode = readln()
    val bankName = getBank(bankCode)
    println(bankName)


}

fun checkProductInStock(
    search: String,
    productList: List<ProductModel>,
    onResult: (Boolean) -> Unit
) {
    if (productList.isEmpty()) {
        onResult(false)
        return
    }

    val list: MutableList<ProductModel> = mutableListOf()

    for (product in productList) {
        if (product.name.lowercase().contains(search.lowercase()) || product.brand.lowercase()
                .contains(search.lowercase())
        ) {
            list.add(product)
        }
    }

    val result = if (list.isEmpty()) false else true
    onResult(result)
}

fun getBank(bankCode: String): String = when (bankCode) {
    "00001" -> "ABA BAnk"
    "0002" -> "Chip Mong Commercial Bank"
    else -> "Invalid Bank"
}