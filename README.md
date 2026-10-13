# Chat Bot (Android)

An Android chat app that sends user messages to the BrainShop chatbot API and shows the replies in a chat-style interface.

## Features
- Chat screen with separate user and bot message bubbles (RecyclerView)
- Network calls to the BrainShop API with Retrofit
- Simple message model and adapter structure

## Tech stack
Java · Android SDK (min 21, target 32) · Retrofit · Gradle

## Setup
1. Clone the repo and open it in Android Studio.
2. Get a free bot ID and key from [brainshop.ai](https://brainshop.ai).
3. Add them to `local.properties` (this file is git-ignored):
   ```
   brainshop.bid=YOUR_BOT_ID
   brainshop.key=YOUR_API_KEY
   ```
4. Run on an emulator or device.

## Project structure
```
app/src/main/java/com/example/chat_bot/
  MainActivity.java     # chat screen and API call
  RetrofitAPI.java      # Retrofit interface
  MsgModel.java         # API response model
  ChatsModel.java       # chat message model
  chatRVAdapter.java    # RecyclerView adapter
```
