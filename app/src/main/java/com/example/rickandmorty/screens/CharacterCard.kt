package com.example.rickandmorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CharacterCard(
    name: String = "Nome do personagem",
    species: String = "Especie do personagem",
    status: String = "Status do personagem",
    image : String = "URL da imagem do personagem",
) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .height(100.dp),


    ) {
        Row (
            modifier = Modifier.fillMaxSize()
        ){ Card(
            modifier = Modifier
                .padding(start = 10.dp)
                .size(80.dp),
            colors = CardDefaults.cardColors(contentColor = Color.Cyan),
            shape = CircleShape
        ) {
            AsyncImage(
                model = "",
                contentDescription = ""
            )
        }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name)
                Text(text = species)
                Text(text = status)
                Text(text = image)
            }

        }
    }

}


@Preview
@Composable
private fun CharacterCard() {
    CharacterCard()
}