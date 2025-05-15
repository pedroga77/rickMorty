package com.example.rickandmorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.model.Result
import com.example.rickandmorty.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun Home(modifier: Modifier = Modifier) {

    var characterList = remember {
        mutableStateOf(listOf<Character>())
    }

    var callCharacters = RetrofitFactory()
        .getCharacterService()
        .listALL()

    callCharacters.enqueue(object : Callback<Result>{
        override fun onResponse(p0: Call<Result>, reponse : Response<Result>) {
            characterList.value = reponse.body()!!.results
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Box(
        modifier = Modifier.fillMaxSize()
            .height(100.dp)


    ){
        Image(
            painter = painterResource(R.drawable.rick_sanches),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxSize()
            .background(Color(0x66000000))
        )
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ){
            Text(
                text = "Rick & Morty",
                color = Color.White,
                fontSize = 48.sp,
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = ""
                        )
                    }
                }

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Character List",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(characterList.value){
                    CharacterCard(
                        name = it.name,
                        status = it.status,
                        species = it.species,
                        image = it.image
                    )

            }
            }
        }
    }
}


@Preview
@Composable
private fun HomePreview() {
    Home()
}
