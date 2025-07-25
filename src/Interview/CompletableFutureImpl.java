package Interview;

import java.io.Serializable;
import java.util.concurrent.*;

public class CompletableFutureImpl {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "SUjAY");

        CompletableFuture<String> greetingFuture = userFuture.thenCompose(user ->
                CompletableFuture.supplyAsync(() -> "Hello, " + user + "!")
        );

        greetingFuture.thenAccept(System.out::println);
//        greetingFuture.get();

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(f1, f2);
        voidCompletableFuture.thenRun(()-> {
            try {
                System.out.println(f1.get() + f2.join());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> scf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "SUjAY";
        });
        CompletableFuture<String> rcf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ROhIT";
        });

        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(rcf, scf);
        Object now = objectCompletableFuture.getNow("scf.get()");
        System.out.println("Now "+now);
        objectCompletableFuture.thenApply(val -> val + " added from Apply")
                .thenAccept(val-> System.out.println("From Accept: "+val))
                .thenRun(System.out::println);
        objectCompletableFuture.thenAccept(result-> System.out.println("Winner "+result));

    }
}

/*
*
✅ 12. Interview Questions You Must Prepare

🔸 Beginner:
What is CompletableFuture and how is it different from Future?
What are thenApply, thenAccept, and thenRun?
🔸 Intermediate:
Explain thenCombine, thenCompose, and allOf.
How to handle exceptions in a CompletableFuture chain?
How do you avoid blocking?
🔸 Advanced:
How does CompletableFuture use ForkJoinPool?
Can you write a retry mechanism with timeout fallback?
What’s the difference between handle() and whenComplete()?
Explain performance pitfalls with commonPool().
How to use CompletableFuture in microservices?
*
* */