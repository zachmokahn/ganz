## Ganz (Complete)

Ganz is a way to traverse a directory tree within the browser. Pretty
aweomsome right?

In order to get this thing started you might need a couple of things. The first
thing you need is Java... because it's built in Java. You can find it
[here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

The application is built off of the
[Umwelt](http://www.github.com/zachmokahn/umwelt) framework. It is used a very
low level web application framework for Java.

### Using this file server:
To experiment with the file server all you have to do is clone the repo:
```
  $ git clone http://www.github.com/zachmokahn/ganz.git
```

Then run the server script:
```
  $ ./server
```

You may need to give it runnable access:
```
  $ chmod 777 ./server
```

After that you can traverse the entire git directory through the browser.

#### But Zack, looking at the git repository for the server is borrrrring

Don't I know it? It's simple, all you have to do is pass it some directory
parameters prefixed with ``` -d ```:
```
  $ ./server -d /Users/
```

#### But Zack, port 5000 is already in use :-(
Don't sweat it, you can open this bad boy up on any port you'd like, it just
takes another parameter prefix -> ``` -p ```:
```
  $ ./server -p 3000
```


#### Can I use these commands together?
Well of course, I usually do!
```
  $ ./server -p 9090 -d /Users/zacharyjdavy/dotfiles
```

#### Wait, dotfiles? You use dotfiles?
Of course I do, And I take great pride in them. They are located at my
[dotfile](http://www.github.com/zachmokahn/dotfiles) repo.
