package br.com.dominio.ateliergracalima.modelo

import java.math.BigDecimal

data class Produto(
    val nomeVaso: String,
    val colecao: String,
    val descricao: String,
    val valor: BigDecimal

)
