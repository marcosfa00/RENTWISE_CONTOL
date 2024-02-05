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
import androidx.room.Room
import com.rentwise.project.data.Data
import com.rentwise.project.data.Data.currentState
import com.rentwise.project.data.TAG
import com.rentwise.project.database.sqlite.users.AppDatabase
import com.rentwise.project.ui.theme.*
import com.rentwise.project.ui.theme.RENTWISE_CONTROLTheme


class MainActivity() : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RENTWISE_CONTROLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(
                        this,
                        AppDatabase::class.java,
                        "user"
                    ).build()
                    val dao = database.userDAO()

                    val viewModel = ViewModel(dao)
                    viewModel.getUsers()

                    Greeting(viewModel)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Estado actual: ${currentState.value}")
        currentState.value = Data.AppState.LOGIN
    }
}


@Composable
fun Greeting(vModel: ViewModel) {
    when (currentState.value) {
        Data.AppState.START, Data.AppState.LOGIN -> {
            SignIn(vModel)
            Log.d(TAG, "Estado actual: ${currentState.value}")
        }
        Data.AppState.REGISTRO -> {
            CenteredMyForm(vModel)
        }
        Data.AppState.HOME ->{
            WelcomeHome(vModel)
        }
        Data.AppState.HOUSE ->{
            InsideHouse(vModel = vModel)
        }
    }
}


