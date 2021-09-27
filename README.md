# Axyos Gaming News

:newspaper: Gaming News App using [RSS.app] to fetch articles from sites that don't have an Public API. The main goal of this project is to practise with some Android development tools & concepts - (Kotlin, MVVM, Dependecy Injection, Architecture Components)

## Screenshots
<p>
  <img src="https://github.com/Ashhas/axyos-gaming-news/blob/main/screenshots/app-walkthrough.gif" width="225">
  <img src="https://github.com/Ashhas/axyos-gaming-news/blob/main/screenshots/Screenshot_20210927-205725.jpg" width="225"> 
  <img src="https://github.com/Ashhas/axyos-gaming-news/blob/main/screenshots/Screenshot_20210927-205720.jpg" width="225">
 </p>

## Made With 🛠
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) 
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) 
- [Koin](https://insert-koin.io/)
- [Retrofit](https://square.github.io/retrofit/)
- [SimpleXML Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)

## Things to Know ✓

- Working with RSS.app wasn't as smooth as I expected. A lot of values (namely the article image) return a lot of HTML elements with them as well.
  This means that I'll have to filter the URL's out of the retrieved string (w/ regular expressions) which increases the chances something might go wrong.
  
- Due to the "intermediate" webpage that RSS.app has in trial mode, I can't open the the articles in a android webview. The counter in the webpage doesn't count down when I do.     That's why I choose to open the URL in the web browser instead.

- Due to the RSS.app trial there's also a limit on 5 articles received per URL.

[RSS.app]:https://rss.app/
[intermediate]:https://github.com/Ashhas/axyos-gaming-news/blob/main/screenshots/app-walkthrough.gif
