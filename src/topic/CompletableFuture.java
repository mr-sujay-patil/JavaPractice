package topic;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFuture {

    public static void main(String[] args) throws Exception {
        demonstrateBasicDifferences();
        demonstrateReturnTypes();
        demonstrateChaining();
        demonstrateErrorHandling();
        demonstrateCustomExecutors();
        demonstrateRealWorldExamples();
    }

    // 1. Basic Differences
    public static void demonstrateBasicDifferences() {
        System.out.println("=== BASIC DIFFERENCES ===");

        // runAsync - for tasks that don't return a value
        java.util.concurrent.CompletableFuture<Void> runAsyncTask = java.util.concurrent.CompletableFuture.runAsync(() -> {
            System.out.println("runAsync: Executing task on thread: " +
                    Thread.currentThread().getName());
            // Simulate some work
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("runAsync: Task completed - no return value");
        });

        // supplyAsync - for tasks that return a value
        java.util.concurrent.CompletableFuture<String> supplyAsyncTask = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync: Executing task on thread: " +
                    Thread.currentThread().getName());
            // Simulate some work
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            return "supplyAsync: Task completed with result";
        });

        try {
            // Get results
            runAsyncTask.get(); // Returns null (Void)
            String result = supplyAsyncTask.get(); // Returns actual result
            System.out.println("Result from supplyAsync: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // 2. Return Types and Functional Interfaces
    public static void demonstrateReturnTypes() {
        System.out.println("=== RETURN TYPES AND FUNCTIONAL INTERFACES ===");

        // runAsync uses Runnable (void -> void)
        Runnable runnableTask = () -> {
            System.out.println("Runnable task executing...");
            performSomeWork();
        };

        // supplyAsync uses Supplier<T> (void -> T)
        Supplier<Integer> supplierTask = () -> {
            System.out.println("Supplier task executing...");
            performSomeWork();
            return 42; // Returns a value
        };

        java.util.concurrent.CompletableFuture<Void> voidFuture = java.util.concurrent.CompletableFuture.runAsync(runnableTask);
        java.util.concurrent.CompletableFuture<Integer> integerFuture = java.util.concurrent.CompletableFuture.supplyAsync(supplierTask);

        try {
            Void voidResult = voidFuture.get(); // Always null
            Integer intResult = integerFuture.get(); // Actual value

            System.out.println("runAsync result: " + voidResult);
            System.out.println("supplyAsync result: " + intResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // 3. Chaining Operations
    public static void demonstrateChaining() {
        System.out.println("=== CHAINING OPERATIONS ===");

        // runAsync chaining - limited options
        java.util.concurrent.CompletableFuture<Void> runAsyncChain = java.util.concurrent.CompletableFuture.runAsync(() -> {
            System.out.println("Step 1: Initial runAsync task");
            performSomeWork();
        }).thenRun(() -> {
            System.out.println("Step 2: Another runAsync task");
            performSomeWork();
        });

        // supplyAsync chaining - more options
        java.util.concurrent.CompletableFuture<String> supplyAsyncChain = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Initial supply task");
            performSomeWork();
            return "Initial Result";
        }).thenApply(result -> {
            System.out.println("Step 2: Transform result: " + result);
            return result.toUpperCase();
        }).thenApply(result -> {
            System.out.println("Step 3: Further transform: " + result);
            return "Final: " + result;
        });

        try {
            runAsyncChain.get();
            String finalResult = supplyAsyncChain.get();
            System.out.println("Final chained result: " + finalResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // 4. Error Handling
    public static void demonstrateErrorHandling() {
        System.out.println("=== ERROR HANDLING ===");

        // runAsync with exception
        java.util.concurrent.CompletableFuture<Void> runAsyncWithError = java.util.concurrent.CompletableFuture.runAsync(() -> {
            System.out.println("runAsync: About to throw exception");
            if (Math.random() > 0.5) {
                throw new RuntimeException("runAsync failed!");
            }
            System.out.println("runAsync: Completed successfully");
        }).exceptionally(throwable -> {
            System.out.println("runAsync exception handled: " + throwable.getMessage());
            return null; // Must return Void (null)
        });

        // supplyAsync with exception
        java.util.concurrent.CompletableFuture<String> supplyAsyncWithError = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync: About to throw exception");
            if (Math.random() > 0.5) {
                throw new RuntimeException("supplyAsync failed!");
            }
            return "supplyAsync: Success";
        }).exceptionally(throwable -> {
            System.out.println("supplyAsync exception handled: " + throwable.getMessage());
            return "Default value"; // Return default value
        });

        try {
            runAsyncWithError.get();
            String result = supplyAsyncWithError.get();
            System.out.println("Error handling result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    // 5. Custom Executors
    public static void demonstrateCustomExecutors() {
        System.out.println("=== CUSTOM EXECUTORS ===");

        ExecutorService customExecutor = Executors.newFixedThreadPool(3);

        try {
            // runAsync with custom executor
            java.util.concurrent.CompletableFuture<Void> runAsyncCustom = java.util.concurrent.CompletableFuture.runAsync(() -> {
                System.out.println("runAsync with custom executor on thread: " +
                        Thread.currentThread().getName());
                performSomeWork();
            }, customExecutor);

            // supplyAsync with custom executor
            java.util.concurrent.CompletableFuture<String> supplyAsyncCustom = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                System.out.println("supplyAsync with custom executor on thread: " +
                        Thread.currentThread().getName());
                performSomeWork();
                return "Custom executor result";
            }, customExecutor);

            runAsyncCustom.get();
            String result = supplyAsyncCustom.get();
            System.out.println("Custom executor result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customExecutor.shutdown();
        }

        System.out.println();
    }

    // 6. Real-World Examples
    public static void demonstrateRealWorldExamples() {
        System.out.println("=== REAL-WORLD EXAMPLES ===");

        // Example 1: File operations
        System.out.println("1. File Operations:");

        // runAsync for file deletion (no return value needed)
        java.util.concurrent.CompletableFuture<Void> deleteFile = java.util.concurrent.CompletableFuture.runAsync(() -> {
            System.out.println("Deleting temporary files...");
            // Simulate file deletion
            try { Thread.sleep(500); } catch (InterruptedException e) {}
            System.out.println("Files deleted successfully");
        });

        // supplyAsync for file reading (returns content)
        java.util.concurrent.CompletableFuture<String> readFile = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println("Reading configuration file...");
            // Simulate file reading
            try { Thread.sleep(800); } catch (InterruptedException e) {}
            return "config.properties content";
        });

        // Example 2: Database operations
        System.out.println("\n2. Database Operations:");

        // runAsync for cache warming (no return value)
        java.util.concurrent.CompletableFuture<Void> warmCache = java.util.concurrent.CompletableFuture.runAsync(() -> {
            System.out.println("Warming up cache...");
            // Simulate cache warming
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("Cache warmed successfully");
        });

        // supplyAsync for data fetching (returns data)
        java.util.concurrent.CompletableFuture<String> fetchData = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user data...");
            // Simulate database query
            try { Thread.sleep(1200); } catch (InterruptedException e) {}
            return "User{id=1, name='John', email='john@example.com'}";
        });

        // Example 3: Combining both
        System.out.println("\n3. Combining Operations:");

        java.util.concurrent.CompletableFuture<String> combinedOperation = java.util.concurrent.CompletableFuture
                .runAsync(() -> {
                    System.out.println("Initializing system...");
                    try { Thread.sleep(300); } catch (InterruptedException e) {}
                })
                .thenCompose(v -> java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                    System.out.println("Loading configuration...");
                    try { Thread.sleep(400); } catch (InterruptedException e) {}
                    return "System configured";
                }))
                .thenApply(config -> {
                    System.out.println("Processing: " + config);
                    return "Application started with " + config;
                });

        try {
            deleteFile.get();
            String fileContent = readFile.get();
            System.out.println("File content: " + fileContent);

            warmCache.get();
            String userData = fetchData.get();
            System.out.println("User data: " + userData);

            String combinedResult = combinedOperation.get();
            System.out.println("Combined result: " + combinedResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to simulate work
    private static void performSomeWork() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
=== KEY DIFFERENCES SUMMARY ===

RUNASYNC:
- Purpose: Execute tasks that don't return values (fire-and-forget)
- Functional Interface: Runnable (void -> void)
- Return Type: CompletableFuture<Void>
- Use Cases: Logging, cleanup, notifications, side effects
- Chaining: Limited to thenRun(), thenRunAsync()

SUPPLYASYNC:
- Purpose: Execute tasks that return values
- Functional Interface: Supplier<T> (void -> T)
- Return Type: CompletableFuture<T>
- Use Cases: Data fetching, calculations, transformations
- Chaining: Rich API with thenApply(), thenCompose(), etc.

WHEN TO USE:
- runAsync: When you need to perform actions without caring about return values
- supplyAsync: When you need to compute and return results for further processing

COMMON PATTERNS:
- runAsync: Async logging, cache warming, cleanup tasks
- supplyAsync: API calls, database queries, file operations with results
*/
