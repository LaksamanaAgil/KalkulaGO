package com.laksamana.kalkulago.Data

class Tokenizer(val input: String) {
    // TODO: Variabel yang berfungsi untuk menyimpan posisi angka yang diinput kedalam kalkulator
    var pos = 0
    // TODO: Menambahkan variabel token yang bersifat fillable/dapat diisi. Nilai default varuabel null/kosong
    var token: String? = null
    //TODO: Memajukan field pos ke karakter non-whitespace selanjutnya didalam string input
    fun nextToken() {
        while (pos < input.length && input[pos].isWhitespace()) { //TODO: Dijalankan selama pos < panjang input serta karakter input merupakan karakter whitespace (space, tab, dsb)
            pos++
        }
        if (pos == input.length) { //TODO: Men-set token field menjadi null jika sudah mencapai batas akhir input string
            token = null
            return
        }

        // TODO: Jika karakter termasuk sebuah digit/angka atau angka desimal, maka semua digit dan angka desimal ditambahkan kedalam sebuah string builder
        if (input[pos].isDigit() || input[pos] == '.') {
            val sb = StringBuilder()
            while (pos < input.length && (input[pos].isDigit() || input[pos] == '.')) {
                sb.append(input[pos])
                pos++
            }
            token = sb.toString() //TODO: Meng-setting token field ke string hasil dari StringBuilder
            return
        }
        if ("+-×÷()".contains(input[pos])) { //TODO: Jika karakter yang dimasukkan merupakan operator atau parentesis/kurung, maka token field cukup di set di satu karakter tersebut, agar tidak melebihi 1 operator sebelum meamasukkan digit berikutnya
            token = input[pos].toString()
            pos++
            return
        }
        throw IllegalArgumentException("Invalid character: ${input[pos]}") //TODO: Method menjalankan illegal argument expression jika karakter yang dimasukkan invalid
    }
}

///TODO: Fungsi evaluate berfungsi sebagai entrypoint menuju parser
fun evaluate(expression: String): Double { //TODO: Fungsi evaluate mengambil dan menetapkan sebuah input string sebagai parameter
    val tokenizer = Tokenizer(expression) //TODO: Membuat sebuah tokenizer berdasarkan parameter tersebut
    tokenizer.nextToken() //TODO: Memanggil fungsi nextToken
    return parseExpression(tokenizer) //TODO: Melanjutkan tokenizer ke fungsi berikutnya, yaitu ParseExpression
}

// TODO: Fungsi untuk memparsing expression(Operasi tambah/kurang)
fun parseExpression(tokenizer: Tokenizer): Double {
    var result = parseTerm(tokenizer)
    while (tokenizer.token in listOf("+", "-")) {
        val op = tokenizer.token!!
        tokenizer.nextToken()
        val term = parseTerm(tokenizer)
        result = when (op) {
            "+" -> result + term
            "-" -> result - term
            else -> throw IllegalStateException("Invalid operator: $op")
        }
    }
    return result
}

// TODO: FUNGSI UNTUK PARSING TERM DAN MELAKUKAN OPERASI PERKALIAN DAN PEMBAGIAN
fun parseTerm(tokenizer: Tokenizer): Double {
    var result = parseFactor(tokenizer)
    while (tokenizer.token in listOf("×", "÷")) {
        val op = tokenizer.token!!
        tokenizer.nextToken()
        val factor = parseFactor(tokenizer)
        result = when (op) {
            "×" -> result * factor
            "÷" -> result / factor
            else -> throw IllegalStateException("Invalid operator: $op")
        }
    }
    return result

}

// TODO: FUNGSI UNTUK MENGAMBIL NILAI FAKTOR and carry out unary operations and also to handle parenthesis
fun parseFactor(tokenizer: Tokenizer): Double {
    if (tokenizer.token == null) {
        throw IllegalArgumentException("Missing factor")
    }
    //TODO: MENGECEK APAKAH TOKEN SEBUAH ANGKA
    if (tokenizer.token!!.toDoubleOrNull() != null) {
        val value = tokenizer.token!!.toDouble()
        tokenizer.nextToken()
        return value
    }

    //TODO: MENGECEK APAKAH TOKEN MERUPAKAN OPERATOR PENAMBAHAN DAN PENGURANGAN)
    if (tokenizer.token in listOf("+", "-")) {
        val op = tokenizer.token!!
        tokenizer.nextToken()
        val factor = parseFactor(tokenizer)
        return when (op) {
            "+" -> +factor
            "-" -> -factor
            else -> throw IllegalStateException("Invalid operator: $op")
        }
    }

    //TODO: Parsing Parentesis/Kurungan
    if (tokenizer.token == "(" && tokenizer.input.indexOf(")", tokenizer.pos) != -1) { // Added this condition
        tokenizer.nextToken()
        // TODO: PARSING EKSPRESI DIDALAM KURUNGAN
        val value = parseExpression(tokenizer)
        if (tokenizer.token == ")") {
            tokenizer.nextToken()
            return value
        } else {
            throw IllegalArgumentException("Missing closing parenthesis")
        }
    }
    else {
        throw IllegalArgumentException("Invalid factor: ${tokenizer.token}")
    }
}
