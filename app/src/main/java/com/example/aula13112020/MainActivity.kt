package com.example.aula13112020

import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.compose.foundation.Icon
import androidx.compose.ui.platform.setContent
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

//aula mvvm

class MainActivity : AppCompatActivity() {

    //instancia do MainViewModel
    private val viewModel: MainViewModel by viewModels()
    //private lateinit var tool: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //codigo com jetpack - sem xml
        setContent {
            //Text("Olá Mundo")
            MaterialTheme {
                myApp(viewModel.soma)
            }
        }
    }

    @Composable
    fun myApp(somaData:LiveData<Int>) {
        val soma by somaData.observeAsState()

        Scaffold(
            topBar = {

            },
            bodyContent = {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(soma.toString())
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    Toast.makeText(this, "Clicando", Toast.LENGTH_SHORT).show()
                    viewModel.incremento(1)
                }) {
                    Icon(Icons.Filled.Add)
                }
            },
        )
    }

}
    
    
// codigo usado para mvvm e sem jetpack
//        setContentView(R.layout.activity_main)
//        //Toolbar
//        tbHome.setNavigationOnClickListener{
//            viewModel.refresh()
//        }
//
//        //impllementarção com mvvm
//        //viewMolde fica monitorando/observando a soma
//        viewModel.soma.observe(this, Observer {
//            tvRes.text = it.toString()
//        })
//
//
//        fbIncrement.setOnClickListener{
//            viewModel.incremento(1)
//        }


//codigo sem arquitetura
//        regra de negocio dentro da camada de apresentação
//        dentro do view
//        fbIncrement.setOnClickListener {
//            soma++
//            tvRes.text = soma.toString()
//        }
