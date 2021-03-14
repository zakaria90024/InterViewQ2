# InterViewQ2
Smart it position of android apps Developer.


<img src="https://user-images.githubusercontent.com/38391658/111062723-d7008200-84d4-11eb-8984-9a34f7ef772e.png">
get request 

https://jsonplaceholder.typicode.com//photos 

change here....

GlideUrl url = new GlideUrl(thumbnel, new LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build());

        Glide
                .with(readActivity)
                .load(url)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageViewthumb);
                
                
                
                
                
