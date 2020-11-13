package com.example.aula13112020

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//realiza vinculo com a activity

class MainViewModel: ViewModel() {

    //verificar a variavel que ira escutar a soma
    val soma = MutableLiveData<Int>().apply {
        value = 0
    }

    //método que eh chamada para fazer incremento
    //quando flutten buttun é chamado
    fun incremento(num: Int){
        var n = num + 100
        soma.value.let {
            soma.value = it!! + n //garantir que ele nao zero nulo
        }
    }

    //método para reiniciar a soma
    fun refresh(){
        soma.value = 0
    }
}