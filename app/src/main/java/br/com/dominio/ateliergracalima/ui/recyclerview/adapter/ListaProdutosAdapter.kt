package br.com.dominio.ateliergracalima.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.dominio.ateliergracalima.R
import br.com.dominio.ateliergracalima.modelo.Produto

class ListaProdutosAdapter(
    private val context: Context, //Pede o contexto como parametro do construtor para o LayoutInflater
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() { //RecyclerView - Em situações que precisamos apresentar uma mesma View com informações diferentes, como é o caso de uma lista de produtos, podemos utilizar o RecyclerView.

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) { // Processo de vinculação das Views
            val nomeVaso = itemView.findViewById<TextView>(R.id.nomeVaso) //itemView representa o layout que transformamos em uma view e mandamos para a viewHolder
            nomeVaso.text = produto.nomeVaso
            val colecao = itemView.findViewById<TextView>(R.id.colecao)
            colecao.text = produto.colecao
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString() // .toPlainString() para transformar o bigDecimal em uma String
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //responsavel em pegar cada uma das view e fazer o processo de binding - (binding: busca as Views do layout e disponibiliza no código fonte para a modificação dos dados.)
        val inflater = LayoutInflater.from(context) //Criar uma view exclusiva apartir de um layout
        val view = inflater.inflate(R.layout.produto_item, parent,false) //Metodo para transformar um layout em uma view exclusiva
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //config. do viewholder para pegar cada uma das views e colocar o valor esperado. vai indicar qual item que o adapter esta colocando no recyclerview e vai indicar a posição e o viewholder
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int { //Quantos itens vai apresentar dentro do adapter
        return produtos.size
    }

}
