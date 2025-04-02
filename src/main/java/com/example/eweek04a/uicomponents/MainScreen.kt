package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember{
        //mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }
    var switchState by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .aspectRatio(9f / 16f)
    ) {
        TodoListTitle()
        TodoList(todoList)
        Spacer(modifier = Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}