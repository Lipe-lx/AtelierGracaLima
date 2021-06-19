package br.com.dominio.ateliergracalima.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.dominio.ateliergracalima.R
import br.com.dominio.ateliergracalima.dao.ProdutosDao
import br.com.dominio.ateliergracalima.modelo.Produto
import br.com.dominio.ateliergracalima.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) { //AppCompatActivity chamando as views dentro do package layout

    override fun onCreate(savedInstanceState: Bundle?) { //onCreate - executa o codigo abaixo sempre que a Activity for inicializada
        super.onCreate(savedInstanceState) //Para o Android nao temos o metodo main e através da super class Activity, neste caso a AppCompatActivity, inicializamos os processos
        Toast.makeText(this, "Bem vindo(a) ao Atelier Graça Lima!", Toast.LENGTH_SHORT) //Apresentar uma mensagem de boas vindas ao criar a Activity.
            .show() //AppCompatActivity é o context por tanto o "this" é a referencia
    }

    override fun onResume() { // onResume - executa o codigo abaixo sempre quando houver iteração do usuario na activity
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) //findViewById - Chama o recyclerView que é uma ViewGroup com varios métodos
        val dao = ProdutosDao()
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos() ) //Carrega os produtos apartir da metodo busca todos implementado para buscar a lista em ProdutosDao
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton) // logica no botão de adicionar - setOnClickListener aciona o codigo ao clicar
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

}

//        val nomeVaso = findViewById<TextView>(R.id.nomeVaso) //Busca uma view, no caso uma TextView, atraves de seu ID
//        nomeVaso.text = "Tipo Cone" //modifica o texto
//        val colecao = findViewById<TextView>(R.id.colecao)
//        colecao.text = "Harmonia e Equilíbrio"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Tamanho Médio - 80x30cm"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "R$ 230,00"

