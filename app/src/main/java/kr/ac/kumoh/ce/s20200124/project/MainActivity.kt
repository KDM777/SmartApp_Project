package kr.ac.kumoh.ce.s20200124.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import kr.ac.kumoh.ce.s20200124.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: IIAViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {
    val iiaList by viewModel.iiaList.observeAsState(emptyList())

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        IIAResult(
            list=iiaList,
            modifier=Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun IIAResult(list: List<IIA>, modifier: Modifier) {
    Column (
        modifier
    ){
        Text(list.toString())
    }
}