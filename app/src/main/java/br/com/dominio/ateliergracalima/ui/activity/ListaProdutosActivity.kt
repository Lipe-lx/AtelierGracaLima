package br.com.dominio.ateliergracalima.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.dominio.ateliergracalima.R
import br.com.dominio.ateliergracalima.dao.ProdutosDao
import br.com.dominio.ateliergracalima.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) { //AppCompatActivity da suporte a varias versoes do Android, chama as views dentro do package layout

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(
        context = this,
        produtos = dao.buscaTodos()) //implantação do adapter para manter sempre a lista atualizada sem zerar ao reabrir a activity

    override fun onCreate(savedInstanceState: Bundle?) { //onCreate - executa o codigo abaixo sempre que a Activity for inicializada
        super.onCreate(savedInstanceState) //Para o Android nao temos o metodo main e através da super class Activity, neste caso a AppCompatActivity, inicializamos os processos

        Toast.makeText(
            this,
            "Bem vindo(a) ao Atelier Graça Lima!",
            Toast.LENGTH_SHORT
        ) //Apresentar uma mensagem de boas vindas ao criar a Activity.
            .show() //AppCompatActivity é o context por tanto o "this" é a referencia

        configuraRecyclerView() //View principal onde apresenta a lista de produtos
        configuraFab() //Configurações de interação com o usuario do botão de adicionar
    }

    override fun onResume() { // onResume - executa o codigo abaixo sempre quando houver interação do usuario na activity
        super.onResume()
        adapter.atualizaLista(dao.buscaTodos())

    }

    private fun configuraFab() {
        val fab = //fab = Floating Action Button
            findViewById<FloatingActionButton>(R.id.activity_lista_produto_fab) // logica no botão de adicionar - setOnClickListener aciona o codigo ao clicar
        fab.setOnClickListener {
            val intent = Intent(
                this,
                FormularioProdutoActivity::class.java
            ) //quando clicar no botao adiciona irá direto para a Activity FormularioProdutoActivity
            startActivity(intent)
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView =
            findViewById<RecyclerView>(R.id.activity_lista_produto_recyclerView) //findViewById - Chama o recyclerView que é uma ViewGroup com varios métodos
        Log.i("ListaProdutosActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter =
            adapter //Carrega os produtos apartir do metodo busca todos implementado para buscar a lista em ProdutosDao
    }
}


