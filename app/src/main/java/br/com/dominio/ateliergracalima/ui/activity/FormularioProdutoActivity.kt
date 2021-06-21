package br.com.dominio.ateliergracalima.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar) //findViewById busca o botão pelo seu id no layout //.setOnClickListener Pega as informações quando o botao salvar é clickado
        val dao = ProdutosDao() //Integração do DAO com a activity - DAO (base de dados) é aonde vai ficar armazenadas as informações - classe ProdutosDao
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            Log.i("FormularioProduto", "onCreate: $produtoNovo ") // verificação no Logcat
            dao.adiciona(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()} ") // verificação no Logcat
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome_vaso)
        val nome =
            campoNome.text.toString() //.text é sinonimo de getText() - Pega as informações inseridas pelo usuario.

        val campoColecao = findViewById<EditText>(R.id.activity_formulario_produto_colecao)
        val colecao = campoColecao.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = campoDescricao.text.toString()

        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor)
        val valorEmTexto =
            campoValor.text.toString() //Para nao ter erro de conversão é necessario realizar uma verificação por conta do BigDecimal, unidade para calculos monetários.
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nomeVaso = nome,
            colecao = colecao,
            descricao = descricao,
            valor = valor
        )
    }

}

