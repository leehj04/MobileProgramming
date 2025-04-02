package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember { mutableStateOf("") }
    Row (modifier = Modifier.fillMaxWidth()) {
       TextField(
           value = textFieldState,
           onValueChange = {text:String -> textFieldState = text},
           placeholder = {Text("할 일을 입력하세요.")} ,
           modifier = Modifier.weight(1f)
       )
        Button(onClick = {
            val currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
            todoList.add(Item(textFieldState, currentTime))
            textFieldState = ""
        }) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}

