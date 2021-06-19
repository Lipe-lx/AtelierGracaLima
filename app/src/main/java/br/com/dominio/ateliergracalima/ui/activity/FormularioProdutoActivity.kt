package br.com.dominio.ateliergracalima.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.dominio.ateliergracalima.R
import br.com.dominio.ateliergracalima.dao.ProdutosDao
import br.com.dominio.ateliergracalima.modelo.Produto
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) { // AppCompatActivity compatibiliza para todas as versoes do Android e pode chamar diretamente o layout pelo construtor

    override fun onCreate( // toda vez que for criada a activity rodara esse codigo
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar =
            findViewById<Button>(R.id.botao_salvar) //Pega as informações quando o botao salvar é clickado
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nomeVaso)
            val nome = campoNome.text.toString() //Pega as informações inseridas pelo usuario

            val campoColecao = findViewById<EditText>(R.id.colecao)
            val colecao = campoColecao.text.toString()

            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()

            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString() //Para nao ter erro de conversão é necessario realizar uma verificação.
            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto(
                nomeVaso = nome,
                colecao = colecao,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProduto", "onCreate: $produtoNovo ")

            val dao = ProdutosDao() //Integração do DAO com a activity - DAO é aonde vai ficar armazenadas as informações - classe ProdutosDao
            dao.adiciona(produtoNovo)

            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()} ")

            finish()

        }

    }

}

