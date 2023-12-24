package com.rentwise.project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rentwise.project.DataClass.currentState
import com.rentwise.project.ui.theme.*
import com.rentwise.project.ui.theme.RENTWISE_CONTROLTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RENTWISE_CONTROLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(viewModel())
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Login", "Estado actual: ${currentState.value}")
        DataClass.currentState.value = DataClass.AppState.LOGIN
    }
}


@Composable
fun Greeting(model: viewModel) {
    when (currentState.value) {
        DataClass.AppState.START, DataClass.AppState.LOGIN -> {
            SignIn(model = model)
            Log.d("Login", "Estado actual: ${currentState.value}")
        }
        DataClass.AppState.REGISTRO -> {
            MyForm()
        }
    }
}


