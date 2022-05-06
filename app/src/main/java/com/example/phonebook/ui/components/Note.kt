package com.example.mynotes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.phonebook.domain.NoteModel
import com.example.phonebook.util.fromHex

@ExperimentalMaterialApi
@Composable
fun Note(
    modifier: Modifier = Modifier,
    number: NoteModel,
    onNumberClick: (NoteModel) -> Unit = {},
    onNoteCheckedChange: (NoteModel) -> Unit = {},
    isSelected: Boolean
) {
    val background = if (isSelected)
        Color.LightGray
    else
        MaterialTheme.colors.surface

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = background
    ) {
        ListItem(
            text = { Text(text = number.name, maxLines = 1) },
            secondaryText = {
                Text(text = number.number, maxLines = 1)
            },
            icon = {
                NoteColor(
                    color = Color.fromHex(number.color.hex),
                    size = 40.dp,
                    border = 1.dp
                )
            },
            modifier = Modifier.clickable {
                onNumberClick.invoke(number)
            }
        )
    }
}
