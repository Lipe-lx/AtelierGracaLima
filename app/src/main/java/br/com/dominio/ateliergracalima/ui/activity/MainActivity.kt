package br.com.dominio.ateliergracalima.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.dominio.ateliergracalima.R
import br.com.dominio.ateliergracalima.modelo.Produto
import br.com.dominio.ateliergracalima.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //Para o Android nao temos o metodo main e através da super class Activity, neste caso a AppCompatActivity, inicializamos os processos
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo(a) ao Atelier Graça Lima!", Toast.LENGTH_SHORT).show() //AppCompatActivity é o context por tanto o "this" é a referencia
        setContentView(R.layout.activity_main) //setContentView - Chama as views do package "res" - resource

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) //Chama o recyclerView
        recyclerView.adapter = ListaProdutosAdapter(this, listOf(
                Produto(
                    nomeVaso = "Estilo Gota",
                    colecao = "Harmonia e Equilíbrio",
                    descricao = "Tamanho Médio: 80x30cm",
                    valor = BigDecimal("235.00")
                ),
                Produto(
                    nomeVaso = "Estilo Cone",
                    colecao = "Harmonia e Equilíbrio",
                    descricao = "Tamanho Médio: 70x30cm",
                    valor = BigDecimal("205.00")
                ),
                Produto(
                    nomeVaso = "Triangular Reto",
                    colecao = "Harmonia e Equilíbrio",
                    descricao = "Tamanho Médio: 80x30cm",
                    valor = BigDecimal("255.00")
                ),
                Produto(
                    nomeVaso = "Estilo Sino",
                    colecao = "Harmonia e Equilíbrio",
                    descricao = "Tamanho Grande: 85x40cm",
                    valor = BigDecimal("335.00")
                ),
            )
        )


//        val nomeVaso = findViewById<TextView>(R.id.nomeVaso) //Busca uma view, no caso uma TextView, atraves de seu ID
//        nomeVaso.text = "Tipo Cone" //modifica o texto
//        val colecao = findViewById<TextView>(R.id.colecao)
//        colecao.text = "Harmonia e Equilíbrio"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Tamanho Médio - 80x30cm"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "R$ 230,00"
    }

}
