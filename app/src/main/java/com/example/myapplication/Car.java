package com.example.myapplication;

public class Car {

        private String name;
        private String slug;
        private Image image;

        // Constructors, getters, and setters

        public Car() {
            // Default constructor
        }

        public Car(String name, String slug, Image image) {
            this.name = name;
            this.slug = slug;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        // Nested class for Image
        public static class Image {
            private String source;
            private String thumb;
            private String optimized;
            private String original;
            private String localThumb;
            private String localOptimized;
            private String localOriginal;

            // Constructors, getters, and setters for Image class

            public Image() {
                // Default constructor
            }

            public Image(String source, String thumb, String optimized, String original, String localThumb, String localOptimized, String localOriginal) {
                this.source = source;
                this.thumb = thumb;
                this.optimized = optimized;
                this.original = original;
                this.localThumb = localThumb;
                this.localOptimized = localOptimized;
                this.localOriginal = localOriginal;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getOptimized() {
                return optimized;
            }

            public void setOptimized(String optimized) {
                this.optimized = optimized;
            }

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public String getLocalThumb() {
                return localThumb;
            }

            public void setLocalThumb(String localThumb) {
                this.localThumb = localThumb;
            }

            public String getLocalOptimized() {
                return localOptimized;
            }

            public void setLocalOptimized(String localOptimized) {
                this.localOptimized = localOptimized;
            }

            public String getLocalOriginal() {
                return localOriginal;
            }

            public void setLocalOriginal(String localOriginal) {
                this.localOriginal = localOriginal;
            }
        }
    }


