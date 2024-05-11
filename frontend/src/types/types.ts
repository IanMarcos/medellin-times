export type NewArticle = {
  title: string | null;
  subtitle: string | null;
  content: string | null;
  author: string | null;
};

export type Image = {
  id: number;
  url: string;
};

export type News = NewArticle & {
  id: number;
  createdAt: string;
  updatedAt: string;
  enabled: number;
  images: Image[];
};
