package kr.ac.kumoh.ce.s20200124.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        IIAList(
            list=iiaList,
            modifier=Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun IIAList(list: List<IIA>, modifier: Modifier) {
    LazyColumn (
        modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal=8.dp)
    ){
        items(list){iia->
            IIAItem(iia)
        }
    }
}

@Composable
fun IIAItem(iia:IIA){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffffffcc))
            .padding(16.dp)
    ) {
        TextName(iia.name)
        TextInterest(iia.interest)
    }
}

@Composable
fun TextName(name:String){
    Text(name, fontSize = 30.sp)
}

@Composable
fun TextInterest(interest:String){
    Text(interest, fontSize = 20.sp)
}