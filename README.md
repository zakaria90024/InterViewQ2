# InterViewQ2
Smart it position of android apps Developer.

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
