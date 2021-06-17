package br.com.dominio.ateliergracalima

import android.app.Activity
import android.os.Bundle
import android.os.TestLooperManager
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) { //Para o Android nao temos o metodo main e através da super class Activity inicializamos os processos
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo(a) ao Atelier Graça Lima!", Toast.LENGTH_SHORT).show() //Activity é o context por tanto o "this" é a referencia
        setContentView(R.layout.activity_main) //Chama as views do package "res" - resource

        val nomeVaso = findViewById<TextView>(R.id.nomeVaso) //Busca uma view, no caso uma TextView, atraves de seu ID
        nomeVaso.text = "Tipo Cone" //modifica o texto
        val colecao = findViewById<TextView>(R.id.colecao)
        colecao.text = "Harmonia e Equilíbrio"
        val descricao = findViewById<TextView>(R.id.descricao)
        descricao.text = "Tamanho Médio - 80x30cm"
        val valor = findViewById<TextView>(R.id.valor)
        valor.text = "R$ 230,00"
    }

}
