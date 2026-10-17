# Chat Bot (Android)

A small Android chat app: type a message, get a reply from a hosted chatbot API, shown as chat bubbles.

![Java](https://img.shields.io/badge/Java-8-ED8B00?logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-min_21_%2F_target_32-3DDC84?logo=android&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-2.9-48B983)
[![Android build](https://github.com/smadhu6364-beep/Chat_Bot/actions/workflows/android.yml/badge.svg)](https://github.com/smadhu6364-beep/Chat_Bot/actions/workflows/android.yml)

> **Status: archived college project.** The app still compiles (checked in CI on every push), but the BrainShop API it talks to has shut down: `brainshop.ai` now redirects to a domain-for-sale page and `api.brainshop.ai` no longer responds (checked October 2026). Messages will get no reply until the API call is pointed at a different chatbot service.

## Features

- Chat screen with separate user and bot message bubbles (RecyclerView + custom adapter)
- HTTP calls with Retrofit and Gson
- API credentials read from `local.properties` at build time, never committed

## Stack

Java, Android SDK (min 21, target 32), AndroidX AppCompat, Material Components, Retrofit 2, Gradle 7.3 / Android Gradle Plugin 7.2

## Build it

You need Android Studio (or JDK 11 + the Android SDK).

```bash
git clone https://github.com/smadhu6364-beep/Chat_Bot.git
cd Chat_Bot
./gradlew assembleDebug      # APK in app/build/outputs/apk/debug/
```

The old BrainShop credentials go in `local.properties` (git-ignored):

```
brainshop.bid=YOUR_BOT_ID
brainshop.key=YOUR_API_KEY
```

## Reviving it

The only network code is in `MainActivity.getResponse()` and `RetrofitAPI`. To bring the bot back, swap the BrainShop URL for another chat API (for example an LLM endpoint behind your own small server, so the key never ships inside the APK) and update `MsgModel` to match its JSON. Upgrading to a current Android Gradle Plugin and target SDK would also be needed before publishing anywhere.

## Structure

```
app/src/main/java/com/example/chat_bot/
  MainActivity.java     chat screen and API call
  RetrofitAPI.java      Retrofit interface
  MsgModel.java         API response model
  ChatsModel.java       chat message model
  chatRVAdapter.java    RecyclerView adapter
.github/workflows/      CI: assembleDebug + unit tests
```
