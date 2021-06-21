package br.com.dominio.ateliergracalima.dao

import br.com.dominio.ateliergracalima.modelo.Produto

class ProdutosDao {


    fun adiciona (produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }


}